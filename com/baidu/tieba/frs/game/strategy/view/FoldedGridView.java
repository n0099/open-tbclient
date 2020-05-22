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
    private static final int hzU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private a hAa;
    private int hAb;
    private Drawable hAc;
    private View hzV;
    private int hzW;
    private int hzX;
    private boolean hzY;
    private com.baidu.tieba.frs.game.strategy.view.a hzZ;

    /* loaded from: classes9.dex */
    public interface a {
        void i(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hzW = 0;
        this.hzX = 0;
        this.hzY = true;
        this.hAb = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hzW = 0;
        this.hzX = 0;
        this.hzY = true;
        this.hAb = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.hzW = 0;
        this.hzX = 0;
        this.hzY = true;
        this.hAb = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.hzV != null) {
            bZ(this.hzV);
        }
        if (this.hAb != 0) {
            this.hAc = am.getDrawable(i, this.hAb);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.hzW = i;
        this.hzX = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.hAb = i;
        if (this.hAb == 0) {
            this.hAc = am.getDrawable(i);
        } else {
            this.hAc = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.hzV == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.hzV = frameLayout;
        }
        return this.hzV;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void bZ(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.hzY) {
                    imageView.setImageDrawable(am.getDrawable(this.hzW));
                } else {
                    imageView.setImageDrawable(am.getDrawable(this.hzX));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean bYM() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (bYM()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.hzZ = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.hzV) {
            if (this.hzZ != null && this.hzZ.bYO()) {
                bYN();
            }
        } else if (this.hAa != null && this.hzZ != null) {
            int uH = this.hzZ.uH(i);
            this.hzZ.uG(uH);
            this.hAa.i(uH, this.hzZ.getItem(i));
        }
    }

    private void bYN() {
        this.hzY = !this.hzY;
        bZ(this.hzV);
        if (this.hzZ != null) {
            this.hzZ.nu(this.hzY);
            this.hzZ.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.hzY && this.hAc != null) {
            this.hAc.setBounds(0, (height - hzU) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.hAc.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.hAa = aVar;
    }
}
