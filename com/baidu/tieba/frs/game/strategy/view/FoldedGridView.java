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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class FoldedGridView extends BdGridView implements AdapterView.OnItemClickListener, f {
    private static final int iQu = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private a iQA;
    private int iQB;
    private Drawable iQC;
    private View iQv;
    private int iQw;
    private int iQx;
    private boolean iQy;
    private com.baidu.tieba.frs.game.strategy.view.a iQz;

    /* loaded from: classes22.dex */
    public interface a {
        void m(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iQw = 0;
        this.iQx = 0;
        this.iQy = true;
        this.iQB = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iQw = 0;
        this.iQx = 0;
        this.iQy = true;
        this.iQB = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.iQw = 0;
        this.iQx = 0;
        this.iQy = true;
        this.iQB = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.iQv != null) {
            cz(this.iQv);
        }
        if (this.iQB != 0) {
            this.iQC = ap.getDrawable(i, this.iQB);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.iQw = i;
        this.iQx = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.iQB = i;
        if (this.iQB == 0) {
            this.iQC = ap.getDrawable(i);
        } else {
            this.iQC = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.iQv == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.iQv = frameLayout;
        }
        return this.iQv;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void cz(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.iQy) {
                    imageView.setImageDrawable(ap.getDrawable(this.iQw));
                } else {
                    imageView.setImageDrawable(ap.getDrawable(this.iQx));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean cAg() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (cAg()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.iQz = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.iQv) {
            if (this.iQz != null && this.iQz.cAi()) {
                cAh();
            }
        } else if (this.iQA != null && this.iQz != null) {
            int zx = this.iQz.zx(i);
            this.iQz.zw(zx);
            this.iQA.m(zx, this.iQz.getItem(i));
        }
    }

    private void cAh() {
        this.iQy = !this.iQy;
        cz(this.iQv);
        if (this.iQz != null) {
            this.iQz.pU(this.iQy);
            this.iQz.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.iQy && this.iQC != null) {
            this.iQC.setBounds(0, (height - iQu) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.iQC.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.iQA = aVar;
    }
}
