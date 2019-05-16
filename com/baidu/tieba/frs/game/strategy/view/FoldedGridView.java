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
    private static final int fAN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private View fAO;
    private int fAP;
    private int fAQ;
    private boolean fAR;
    private com.baidu.tieba.frs.game.strategy.view.a fAS;
    private a fAT;
    private int fAU;
    private Drawable fAV;

    /* loaded from: classes4.dex */
    public interface a {
        void f(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fAP = 0;
        this.fAQ = 0;
        this.fAR = true;
        this.fAU = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fAP = 0;
        this.fAQ = 0;
        this.fAR = true;
        this.fAU = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.fAP = 0;
        this.fAQ = 0;
        this.fAR = true;
        this.fAU = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.fAO != null) {
            bR(this.fAO);
        }
        if (this.fAU != 0) {
            this.fAV = al.S(i, this.fAU);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.fAP = i;
        this.fAQ = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.fAU = i;
        if (this.fAU == 0) {
            this.fAV = al.getDrawable(i);
        } else {
            this.fAV = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.fAO == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.fAO = frameLayout;
        }
        return this.fAO;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void bR(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.fAR) {
                    imageView.setImageDrawable(al.getDrawable(this.fAP));
                } else {
                    imageView.setImageDrawable(al.getDrawable(this.fAQ));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean bnx() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (bnx()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.fAS = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.fAO) {
            if (this.fAS != null && this.fAS.bnz()) {
                bny();
            }
        } else if (this.fAT != null && this.fAS != null) {
            int rR = this.fAS.rR(i);
            this.fAS.rQ(rR);
            this.fAT.f(rR, this.fAS.getItem(i));
        }
    }

    private void bny() {
        this.fAR = !this.fAR;
        bR(this.fAO);
        if (this.fAS != null) {
            this.fAS.kq(this.fAR);
            this.fAS.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.fAR && this.fAV != null) {
            this.fAV.setBounds(0, (height - fAN) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.fAV.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.fAT = aVar;
    }
}
