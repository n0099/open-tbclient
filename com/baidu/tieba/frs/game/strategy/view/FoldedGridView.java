package com.baidu.tieba.frs.game.strategy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class FoldedGridView extends BdGridView implements AdapterView.OnItemClickListener, f {
    private static final int fks = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds48);
    private Drawable fkA;
    private View fkt;
    private int fku;
    private int fkv;
    private boolean fkw;
    private com.baidu.tieba.frs.game.strategy.view.a fkx;
    private a fky;
    private int fkz;

    /* loaded from: classes4.dex */
    public interface a {
        void f(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fku = 0;
        this.fkv = 0;
        this.fkw = true;
        this.fkz = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fku = 0;
        this.fkv = 0;
        this.fkw = true;
        this.fkz = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.fku = 0;
        this.fkv = 0;
        this.fkw = true;
        this.fkz = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.fkt != null) {
            bJ(this.fkt);
        }
        if (this.fkz != 0) {
            this.fkA = al.T(i, this.fkz);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.fku = i;
        this.fkv = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.fkz = i;
        if (this.fkz == 0) {
            this.fkA = al.getDrawable(i);
        } else {
            this.fkA = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.fkt == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.fkt = frameLayout;
        }
        return this.fkt;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void bJ(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.fkw) {
                    imageView.setImageDrawable(al.getDrawable(this.fku));
                } else {
                    imageView.setImageDrawable(al.getDrawable(this.fkv));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean bgg() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (bgg()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.fkx = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.fkt) {
            if (this.fkx != null && this.fkx.bgi()) {
                bgh();
            }
        } else if (this.fky != null && this.fkx != null) {
            int qJ = this.fkx.qJ(i);
            this.fkx.qI(qJ);
            this.fky.f(qJ, this.fkx.getItem(i));
        }
    }

    private void bgh() {
        this.fkw = !this.fkw;
        bJ(this.fkt);
        if (this.fkx != null) {
            this.fkx.jE(this.fkw);
            this.fkx.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.fkw && this.fkA != null) {
            this.fkA.setBounds(0, (height - fks) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.fkA.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.fky = aVar;
    }
}
