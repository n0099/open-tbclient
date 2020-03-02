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
    private static final int gAu = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private a gAA;
    private int gAB;
    private Drawable gAC;
    private View gAv;
    private int gAw;
    private int gAx;
    private boolean gAy;
    private com.baidu.tieba.frs.game.strategy.view.a gAz;

    /* loaded from: classes9.dex */
    public interface a {
        void i(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gAw = 0;
        this.gAx = 0;
        this.gAy = true;
        this.gAB = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gAw = 0;
        this.gAx = 0;
        this.gAy = true;
        this.gAB = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.gAw = 0;
        this.gAx = 0;
        this.gAy = true;
        this.gAB = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.gAv != null) {
            bR(this.gAv);
        }
        if (this.gAB != 0) {
            this.gAC = am.getDrawable(i, this.gAB);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.gAw = i;
        this.gAx = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.gAB = i;
        if (this.gAB == 0) {
            this.gAC = am.getDrawable(i);
        } else {
            this.gAC = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.gAv == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.gAv = frameLayout;
        }
        return this.gAv;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void bR(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.gAy) {
                    imageView.setImageDrawable(am.getDrawable(this.gAw));
                } else {
                    imageView.setImageDrawable(am.getDrawable(this.gAx));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean bHG() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (bHG()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.gAz = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.gAv) {
            if (this.gAz != null && this.gAz.bHI()) {
                bHH();
            }
        } else if (this.gAA != null && this.gAz != null) {
            int ty = this.gAz.ty(i);
            this.gAz.tx(ty);
            this.gAA.i(ty, this.gAz.getItem(i));
        }
    }

    private void bHH() {
        this.gAy = !this.gAy;
        bR(this.gAv);
        if (this.gAz != null) {
            this.gAz.lQ(this.gAy);
            this.gAz.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.gAy && this.gAC != null) {
            this.gAC.setBounds(0, (height - gAu) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.gAC.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.gAA = aVar;
    }
}
