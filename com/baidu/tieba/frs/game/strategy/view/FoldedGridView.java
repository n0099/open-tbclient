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
    private static final int iWr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private View iWs;
    private int iWt;
    private int iWu;
    private boolean iWv;
    private com.baidu.tieba.frs.game.strategy.view.a iWw;
    private a iWx;
    private int iWy;
    private Drawable iWz;

    /* loaded from: classes22.dex */
    public interface a {
        void l(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iWt = 0;
        this.iWu = 0;
        this.iWv = true;
        this.iWy = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iWt = 0;
        this.iWu = 0;
        this.iWv = true;
        this.iWy = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.iWt = 0;
        this.iWu = 0;
        this.iWv = true;
        this.iWy = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.iWs != null) {
            cE(this.iWs);
        }
        if (this.iWy != 0) {
            this.iWz = ap.getDrawable(i, this.iWy);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.iWt = i;
        this.iWu = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.iWy = i;
        if (this.iWy == 0) {
            this.iWz = ap.getDrawable(i);
        } else {
            this.iWz = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.iWs == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.iWs = frameLayout;
        }
        return this.iWs;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void cE(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.iWv) {
                    imageView.setImageDrawable(ap.getDrawable(this.iWt));
                } else {
                    imageView.setImageDrawable(ap.getDrawable(this.iWu));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean cCH() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (cCH()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.iWw = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.iWs) {
            if (this.iWw != null && this.iWw.cCJ()) {
                cCI();
            }
        } else if (this.iWx != null && this.iWw != null) {
            int zK = this.iWw.zK(i);
            this.iWw.zJ(zK);
            this.iWx.l(zK, this.iWw.getItem(i));
        }
    }

    private void cCI() {
        this.iWv = !this.iWv;
        cE(this.iWs);
        if (this.iWw != null) {
            this.iWw.qd(this.iWv);
            this.iWw.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.iWv && this.iWz != null) {
            this.iWz.setBounds(0, (height - iWr) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.iWz.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.iWx = aVar;
    }
}
