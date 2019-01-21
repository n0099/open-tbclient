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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class FoldedGridView extends BdGridView implements AdapterView.OnItemClickListener, f {
    private static final int dXe = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds48);
    private View dXf;
    private int dXg;
    private int dXh;
    private boolean dXi;
    private com.baidu.tieba.frs.game.strategy.view.a dXj;
    private a dXk;
    private int dXl;
    private Drawable dXm;

    /* loaded from: classes3.dex */
    public interface a {
        void c(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dXg = 0;
        this.dXh = 0;
        this.dXi = true;
        this.dXl = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dXg = 0;
        this.dXh = 0;
        this.dXi = true;
        this.dXl = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.dXg = 0;
        this.dXh = 0;
        this.dXi = true;
        this.dXl = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.dXf != null) {
            aR(this.dXf);
        }
        if (this.dXl != 0) {
            this.dXm = al.y(i, this.dXl);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.dXg = i;
        this.dXh = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.dXl = i;
        if (this.dXl == 0) {
            this.dXm = al.getDrawable(i);
        } else {
            this.dXm = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.dXf == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.dXf = frameLayout;
        }
        return this.dXf;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void aR(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.dXi) {
                    imageView.setImageDrawable(al.getDrawable(this.dXg));
                } else {
                    imageView.setImageDrawable(al.getDrawable(this.dXh));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean aFQ() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (aFQ()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.dXj = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.dXf) {
            if (this.dXj != null && this.dXj.aFS()) {
                aFR();
            }
        } else if (this.dXk != null && this.dXj != null) {
            int na = this.dXj.na(i);
            this.dXj.mZ(na);
            this.dXk.c(na, this.dXj.getItem(i));
        }
    }

    private void aFR() {
        this.dXi = !this.dXi;
        aR(this.dXf);
        if (this.dXj != null) {
            this.dXj.hj(this.dXi);
            this.dXj.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.dXi && this.dXm != null) {
            this.dXm.setBounds(0, (height - dXe) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.dXm.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.dXk = aVar;
    }
}
