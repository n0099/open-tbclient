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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class FoldedGridView extends BdGridView implements AdapterView.OnItemClickListener, e {
    private static final int jxd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private View jxe;
    private int jxf;
    private int jxg;
    private boolean jxh;
    private com.baidu.tieba.frs.game.strategy.view.a jxi;
    private a jxj;
    private int jxk;
    private Drawable jxl;

    /* loaded from: classes2.dex */
    public interface a {
        void l(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jxf = 0;
        this.jxg = 0;
        this.jxh = true;
        this.jxk = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jxf = 0;
        this.jxg = 0;
        this.jxh = true;
        this.jxk = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.jxf = 0;
        this.jxg = 0;
        this.jxh = true;
        this.jxk = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.jxe != null) {
            cZ(this.jxe);
        }
        if (this.jxk != 0) {
            this.jxl = ao.getDrawable(i, this.jxk);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.jxf = i;
        this.jxg = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.jxk = i;
        if (this.jxk == 0) {
            this.jxl = ao.getDrawable(i);
        } else {
            this.jxl = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.e
    public View getArrowView() {
        if (this.jxe == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.jxe = frameLayout;
        }
        return this.jxe;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.e
    public void cZ(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.jxh) {
                    imageView.setImageDrawable(ao.getDrawable(this.jxf));
                } else {
                    imageView.setImageDrawable(ao.getDrawable(this.jxg));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.e
    public boolean cKy() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.e
    public int getArrowIndex() {
        if (cKy()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.jxi = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.jxe) {
            if (this.jxi != null && this.jxi.cKA()) {
                cKz();
            }
        } else if (this.jxj != null && this.jxi != null) {
            int Bi = this.jxi.Bi(i);
            this.jxi.Bh(Bi);
            this.jxj.l(Bi, this.jxi.getItem(i));
        }
    }

    private void cKz() {
        this.jxh = !this.jxh;
        cZ(this.jxe);
        if (this.jxi != null) {
            this.jxi.rf(this.jxh);
            this.jxi.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.jxh && this.jxl != null) {
            this.jxl.setBounds(0, (height - jxd) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.jxl.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.jxj = aVar;
    }
}
