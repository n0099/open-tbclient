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
    private static final int fkG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds48);
    private View fkH;
    private int fkI;
    private int fkJ;
    private boolean fkK;
    private com.baidu.tieba.frs.game.strategy.view.a fkL;
    private a fkM;
    private int fkN;
    private Drawable fkO;

    /* loaded from: classes4.dex */
    public interface a {
        void f(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fkI = 0;
        this.fkJ = 0;
        this.fkK = true;
        this.fkN = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fkI = 0;
        this.fkJ = 0;
        this.fkK = true;
        this.fkN = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.fkI = 0;
        this.fkJ = 0;
        this.fkK = true;
        this.fkN = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.fkH != null) {
            bJ(this.fkH);
        }
        if (this.fkN != 0) {
            this.fkO = al.T(i, this.fkN);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.fkI = i;
        this.fkJ = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.fkN = i;
        if (this.fkN == 0) {
            this.fkO = al.getDrawable(i);
        } else {
            this.fkO = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.fkH == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.fkH = frameLayout;
        }
        return this.fkH;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void bJ(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.fkK) {
                    imageView.setImageDrawable(al.getDrawable(this.fkI));
                } else {
                    imageView.setImageDrawable(al.getDrawable(this.fkJ));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean bgi() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (bgi()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.fkL = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.fkH) {
            if (this.fkL != null && this.fkL.bgk()) {
                bgj();
            }
        } else if (this.fkM != null && this.fkL != null) {
            int qN = this.fkL.qN(i);
            this.fkL.qM(qN);
            this.fkM.f(qN, this.fkL.getItem(i));
        }
    }

    private void bgj() {
        this.fkK = !this.fkK;
        bJ(this.fkH);
        if (this.fkL != null) {
            this.fkL.jE(this.fkK);
            this.fkL.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.fkK && this.fkO != null) {
            this.fkO.setBounds(0, (height - fkG) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.fkO.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.fkM = aVar;
    }
}
