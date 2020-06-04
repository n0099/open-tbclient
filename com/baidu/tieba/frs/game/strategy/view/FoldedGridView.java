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
/* loaded from: classes9.dex */
public class FoldedGridView extends BdGridView implements AdapterView.OnItemClickListener, f {
    private static final int hAH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private View hAI;
    private int hAJ;
    private int hAK;
    private boolean hAL;
    private com.baidu.tieba.frs.game.strategy.view.a hAM;
    private a hAN;
    private int hAO;
    private Drawable hAP;

    /* loaded from: classes9.dex */
    public interface a {
        void i(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hAJ = 0;
        this.hAK = 0;
        this.hAL = true;
        this.hAO = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hAJ = 0;
        this.hAK = 0;
        this.hAL = true;
        this.hAO = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.hAJ = 0;
        this.hAK = 0;
        this.hAL = true;
        this.hAO = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.hAI != null) {
            bZ(this.hAI);
        }
        if (this.hAO != 0) {
            this.hAP = am.getDrawable(i, this.hAO);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.hAJ = i;
        this.hAK = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.hAO = i;
        if (this.hAO == 0) {
            this.hAP = am.getDrawable(i);
        } else {
            this.hAP = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.hAI == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.hAI = frameLayout;
        }
        return this.hAI;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void bZ(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.hAL) {
                    imageView.setImageDrawable(am.getDrawable(this.hAJ));
                } else {
                    imageView.setImageDrawable(am.getDrawable(this.hAK));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean bYU() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (bYU()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.hAM = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.hAI) {
            if (this.hAM != null && this.hAM.bYW()) {
                bYV();
            }
        } else if (this.hAN != null && this.hAM != null) {
            int uJ = this.hAM.uJ(i);
            this.hAM.uI(uJ);
            this.hAN.i(uJ, this.hAM.getItem(i));
        }
    }

    private void bYV() {
        this.hAL = !this.hAL;
        bZ(this.hAI);
        if (this.hAM != null) {
            this.hAM.nu(this.hAL);
            this.hAM.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.hAL && this.hAP != null) {
            this.hAP.setBounds(0, (height - hAH) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.hAP.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.hAN = aVar;
    }
}
