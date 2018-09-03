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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class FoldedGridView extends BdGridView implements AdapterView.OnItemClickListener, f {
    private static final int dxq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds48);
    private View dxr;
    private int dxs;
    private int dxt;
    private boolean dxu;
    private com.baidu.tieba.frs.game.strategy.view.a dxv;
    private a dxw;
    private int dxx;
    private Drawable dxy;

    /* loaded from: classes3.dex */
    public interface a {
        void c(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dxs = 0;
        this.dxt = 0;
        this.dxu = true;
        this.dxx = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dxs = 0;
        this.dxt = 0;
        this.dxu = true;
        this.dxx = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.dxs = 0;
        this.dxt = 0;
        this.dxu = true;
        this.dxx = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.dxr != null) {
            ay(this.dxr);
        }
        if (this.dxx != 0) {
            this.dxy = am.v(i, this.dxx);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.dxs = i;
        this.dxt = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.dxx = i;
        if (this.dxx == 0) {
            this.dxy = am.getDrawable(i);
        } else {
            this.dxy = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.dxr == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.dxr = frameLayout;
        }
        return this.dxr;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void ay(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.dxu) {
                    imageView.setImageDrawable(am.getDrawable(this.dxs));
                } else {
                    imageView.setImageDrawable(am.getDrawable(this.dxt));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean axP() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (axP()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.dxv = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.dxr) {
            if (this.dxv != null && this.dxv.axR()) {
                axQ();
            }
        } else if (this.dxw != null && this.dxv != null) {
            int le = this.dxv.le(i);
            this.dxv.ld(le);
            this.dxw.c(le, this.dxv.getItem(i));
        }
    }

    private void axQ() {
        this.dxu = !this.dxu;
        ay(this.dxr);
        if (this.dxv != null) {
            this.dxv.gc(this.dxu);
            this.dxv.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.dxu && this.dxy != null) {
            this.dxy.setBounds(0, (height - dxq) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.dxy.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.dxw = aVar;
    }
}
