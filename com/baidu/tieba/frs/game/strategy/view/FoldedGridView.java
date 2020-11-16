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
/* loaded from: classes21.dex */
public class FoldedGridView extends BdGridView implements AdapterView.OnItemClickListener, f {
    private static final int iXd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private View iXe;
    private int iXf;
    private int iXg;
    private boolean iXh;
    private com.baidu.tieba.frs.game.strategy.view.a iXi;
    private a iXj;
    private int iXk;
    private Drawable iXl;

    /* loaded from: classes21.dex */
    public interface a {
        void l(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iXf = 0;
        this.iXg = 0;
        this.iXh = true;
        this.iXk = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iXf = 0;
        this.iXg = 0;
        this.iXh = true;
        this.iXk = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.iXf = 0;
        this.iXg = 0;
        this.iXh = true;
        this.iXk = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.iXe != null) {
            cI(this.iXe);
        }
        if (this.iXk != 0) {
            this.iXl = ap.getDrawable(i, this.iXk);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.iXf = i;
        this.iXg = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.iXk = i;
        if (this.iXk == 0) {
            this.iXl = ap.getDrawable(i);
        } else {
            this.iXl = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.iXe == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.iXe = frameLayout;
        }
        return this.iXe;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void cI(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.iXh) {
                    imageView.setImageDrawable(ap.getDrawable(this.iXf));
                } else {
                    imageView.setImageDrawable(ap.getDrawable(this.iXg));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean cCl() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (cCl()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.iXi = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.iXe) {
            if (this.iXi != null && this.iXi.cCn()) {
                cCm();
            }
        } else if (this.iXj != null && this.iXi != null) {
            int Ai = this.iXi.Ai(i);
            this.iXi.Ah(Ai);
            this.iXj.l(Ai, this.iXi.getItem(i));
        }
    }

    private void cCm() {
        this.iXh = !this.iXh;
        cI(this.iXe);
        if (this.iXi != null) {
            this.iXi.qg(this.iXh);
            this.iXi.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.iXh && this.iXl != null) {
            this.iXl.setBounds(0, (height - iXd) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.iXl.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.iXj = aVar;
    }
}
