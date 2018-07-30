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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class FoldedGridView extends BdGridView implements AdapterView.OnItemClickListener, f {
    private static final int dxt = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds48);
    private int dxA;
    private Drawable dxB;
    private View dxu;
    private int dxv;
    private int dxw;
    private boolean dxx;
    private com.baidu.tieba.frs.game.strategy.view.a dxy;
    private a dxz;

    /* loaded from: classes3.dex */
    public interface a {
        void c(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dxv = 0;
        this.dxw = 0;
        this.dxx = true;
        this.dxA = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dxv = 0;
        this.dxw = 0;
        this.dxx = true;
        this.dxA = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.dxv = 0;
        this.dxw = 0;
        this.dxx = true;
        this.dxA = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.dxu != null) {
            ay(this.dxu);
        }
        if (this.dxA != 0) {
            this.dxB = am.v(i, this.dxA);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.dxv = i;
        this.dxw = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.dxA = i;
        if (this.dxA == 0) {
            this.dxB = am.getDrawable(i);
        } else {
            this.dxB = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.dxu == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.dxu = frameLayout;
        }
        return this.dxu;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void ay(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.dxx) {
                    imageView.setImageDrawable(am.getDrawable(this.dxv));
                } else {
                    imageView.setImageDrawable(am.getDrawable(this.dxw));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean axR() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (axR()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.dxy = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.dxu) {
            if (this.dxy != null && this.dxy.axT()) {
                axS();
            }
        } else if (this.dxz != null && this.dxy != null) {
            int lf = this.dxy.lf(i);
            this.dxy.le(lf);
            this.dxz.c(lf, this.dxy.getItem(i));
        }
    }

    private void axS() {
        this.dxx = !this.dxx;
        ay(this.dxu);
        if (this.dxy != null) {
            this.dxy.gc(this.dxx);
            this.dxy.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.dxx && this.dxB != null) {
            this.dxB.setBounds(0, (height - dxt) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.dxB.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.dxz = aVar;
    }
}
