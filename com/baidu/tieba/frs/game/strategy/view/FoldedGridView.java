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
    private static final int dNd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds48);
    private View dNe;
    private int dNf;
    private int dNg;
    private boolean dNh;
    private com.baidu.tieba.frs.game.strategy.view.a dNi;
    private a dNj;
    private int dNk;
    private Drawable dNl;

    /* loaded from: classes3.dex */
    public interface a {
        void c(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dNf = 0;
        this.dNg = 0;
        this.dNh = true;
        this.dNk = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dNf = 0;
        this.dNg = 0;
        this.dNh = true;
        this.dNk = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.dNf = 0;
        this.dNg = 0;
        this.dNh = true;
        this.dNk = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.dNe != null) {
            aO(this.dNe);
        }
        if (this.dNk != 0) {
            this.dNl = al.x(i, this.dNk);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.dNf = i;
        this.dNg = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.dNk = i;
        if (this.dNk == 0) {
            this.dNl = al.getDrawable(i);
        } else {
            this.dNl = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.dNe == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.dNe = frameLayout;
        }
        return this.dNe;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void aO(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.dNh) {
                    imageView.setImageDrawable(al.getDrawable(this.dNf));
                } else {
                    imageView.setImageDrawable(al.getDrawable(this.dNg));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean aCS() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (aCS()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.dNi = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.dNe) {
            if (this.dNi != null && this.dNi.aCU()) {
                aCT();
            }
        } else if (this.dNj != null && this.dNi != null) {
            int mw = this.dNi.mw(i);
            this.dNi.mv(mw);
            this.dNj.c(mw, this.dNi.getItem(i));
        }
    }

    private void aCT() {
        this.dNh = !this.dNh;
        aO(this.dNe);
        if (this.dNi != null) {
            this.dNi.hb(this.dNh);
            this.dNi.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.dNh && this.dNl != null) {
            this.dNl.setBounds(0, (height - dNd) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.dNl.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.dNj = aVar;
    }
}
