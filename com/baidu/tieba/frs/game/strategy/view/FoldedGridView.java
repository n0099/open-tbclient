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
    private static final int dTG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds48);
    private View dTH;
    private int dTI;
    private int dTJ;
    private boolean dTK;
    private com.baidu.tieba.frs.game.strategy.view.a dTL;
    private a dTM;
    private int dTN;
    private Drawable dTO;

    /* loaded from: classes3.dex */
    public interface a {
        void c(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dTI = 0;
        this.dTJ = 0;
        this.dTK = true;
        this.dTN = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dTI = 0;
        this.dTJ = 0;
        this.dTK = true;
        this.dTN = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.dTI = 0;
        this.dTJ = 0;
        this.dTK = true;
        this.dTN = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.dTH != null) {
            aO(this.dTH);
        }
        if (this.dTN != 0) {
            this.dTO = al.y(i, this.dTN);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.dTI = i;
        this.dTJ = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.dTN = i;
        if (this.dTN == 0) {
            this.dTO = al.getDrawable(i);
        } else {
            this.dTO = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.dTH == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.dTH = frameLayout;
        }
        return this.dTH;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void aO(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.dTK) {
                    imageView.setImageDrawable(al.getDrawable(this.dTI));
                } else {
                    imageView.setImageDrawable(al.getDrawable(this.dTJ));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean aEE() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (aEE()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.dTL = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.dTH) {
            if (this.dTL != null && this.dTL.aEG()) {
                aEF();
            }
        } else if (this.dTM != null && this.dTL != null) {
            int mM = this.dTL.mM(i);
            this.dTL.mL(mM);
            this.dTM.c(mM, this.dTL.getItem(i));
        }
    }

    private void aEF() {
        this.dTK = !this.dTK;
        aO(this.dTH);
        if (this.dTL != null) {
            this.dTL.hd(this.dTK);
            this.dTL.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.dTK && this.dTO != null) {
            this.dTO.setBounds(0, (height - dTG) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.dTO.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.dTM = aVar;
    }
}
