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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class FoldedGridView extends BdGridView implements AdapterView.OnItemClickListener, f {
    private static final int fFM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private View fFN;
    private int fFO;
    private int fFP;
    private boolean fFQ;
    private com.baidu.tieba.frs.game.strategy.view.a fFR;
    private a fFS;
    private int fFT;
    private Drawable fFU;

    /* loaded from: classes4.dex */
    public interface a {
        void f(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fFO = 0;
        this.fFP = 0;
        this.fFQ = true;
        this.fFT = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fFO = 0;
        this.fFP = 0;
        this.fFQ = true;
        this.fFT = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.fFO = 0;
        this.fFP = 0;
        this.fFQ = true;
        this.fFT = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.fFN != null) {
            bT(this.fFN);
        }
        if (this.fFT != 0) {
            this.fFU = am.V(i, this.fFT);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.fFO = i;
        this.fFP = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.fFT = i;
        if (this.fFT == 0) {
            this.fFU = am.getDrawable(i);
        } else {
            this.fFU = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.fFN == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.fFN = frameLayout;
        }
        return this.fFN;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void bT(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.fFQ) {
                    imageView.setImageDrawable(am.getDrawable(this.fFO));
                } else {
                    imageView.setImageDrawable(am.getDrawable(this.fFP));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean bpB() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (bpB()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.fFR = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.fFN) {
            if (this.fFR != null && this.fFR.bpD()) {
                bpC();
            }
        } else if (this.fFS != null && this.fFR != null) {
            int sj = this.fFR.sj(i);
            this.fFR.si(sj);
            this.fFS.f(sj, this.fFR.getItem(i));
        }
    }

    private void bpC() {
        this.fFQ = !this.fFQ;
        bT(this.fFN);
        if (this.fFR != null) {
            this.fFR.kA(this.fFQ);
            this.fFR.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.fFQ && this.fFU != null) {
            this.fFU.setBounds(0, (height - fFM) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.fFU.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.fFS = aVar;
    }
}
