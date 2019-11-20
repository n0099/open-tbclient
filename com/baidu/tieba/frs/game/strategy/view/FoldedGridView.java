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
    private static final int fGP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private View fGQ;
    private int fGR;
    private int fGS;
    private boolean fGT;
    private com.baidu.tieba.frs.game.strategy.view.a fGU;
    private a fGV;
    private int fGW;
    private Drawable fGX;

    /* loaded from: classes4.dex */
    public interface a {
        void i(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fGR = 0;
        this.fGS = 0;
        this.fGT = true;
        this.fGW = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fGR = 0;
        this.fGS = 0;
        this.fGT = true;
        this.fGW = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.fGR = 0;
        this.fGS = 0;
        this.fGT = true;
        this.fGW = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.fGQ != null) {
            bR(this.fGQ);
        }
        if (this.fGW != 0) {
            this.fGX = am.getDrawable(i, this.fGW);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.fGR = i;
        this.fGS = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.fGW = i;
        if (this.fGW == 0) {
            this.fGX = am.getDrawable(i);
        } else {
            this.fGX = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.fGQ == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.fGQ = frameLayout;
        }
        return this.fGQ;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void bR(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.fGT) {
                    imageView.setImageDrawable(am.getDrawable(this.fGR));
                } else {
                    imageView.setImageDrawable(am.getDrawable(this.fGS));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean bnD() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (bnD()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.fGU = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.fGQ) {
            if (this.fGU != null && this.fGU.bnF()) {
                bnE();
            }
        } else if (this.fGV != null && this.fGU != null) {
            int rh = this.fGU.rh(i);
            this.fGU.rg(rh);
            this.fGV.i(rh, this.fGU.getItem(i));
        }
    }

    private void bnE() {
        this.fGT = !this.fGT;
        bR(this.fGQ);
        if (this.fGU != null) {
            this.fGU.kq(this.fGT);
            this.fGU.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.fGT && this.fGX != null) {
            this.fGX.setBounds(0, (height - fGP) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.fGX.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.fGV = aVar;
    }
}
