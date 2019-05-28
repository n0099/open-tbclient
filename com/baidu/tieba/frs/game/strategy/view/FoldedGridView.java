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
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class FoldedGridView extends BdGridView implements AdapterView.OnItemClickListener, f {
    private static final int fAO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private View fAP;
    private int fAQ;
    private int fAR;
    private boolean fAS;
    private com.baidu.tieba.frs.game.strategy.view.a fAT;
    private a fAU;
    private int fAV;
    private Drawable fAW;

    /* loaded from: classes4.dex */
    public interface a {
        void f(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fAQ = 0;
        this.fAR = 0;
        this.fAS = true;
        this.fAV = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fAQ = 0;
        this.fAR = 0;
        this.fAS = true;
        this.fAV = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.fAQ = 0;
        this.fAR = 0;
        this.fAS = true;
        this.fAV = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.fAP != null) {
            bR(this.fAP);
        }
        if (this.fAV != 0) {
            this.fAW = al.S(i, this.fAV);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.fAQ = i;
        this.fAR = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.fAV = i;
        if (this.fAV == 0) {
            this.fAW = al.getDrawable(i);
        } else {
            this.fAW = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.fAP == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.fAP = frameLayout;
        }
        return this.fAP;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void bR(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.fAS) {
                    imageView.setImageDrawable(al.getDrawable(this.fAQ));
                } else {
                    imageView.setImageDrawable(al.getDrawable(this.fAR));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean bnA() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (bnA()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.fAT = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.fAP) {
            if (this.fAT != null && this.fAT.bnC()) {
                bnB();
            }
        } else if (this.fAU != null && this.fAT != null) {
            int rR = this.fAT.rR(i);
            this.fAT.rQ(rR);
            this.fAU.f(rR, this.fAT.getItem(i));
        }
    }

    private void bnB() {
        this.fAS = !this.fAS;
        bR(this.fAP);
        if (this.fAT != null) {
            this.fAT.kq(this.fAS);
            this.fAT.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.fAS && this.fAW != null) {
            this.fAW.setBounds(0, (height - fAO) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.fAW.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.fAU = aVar;
    }
}
