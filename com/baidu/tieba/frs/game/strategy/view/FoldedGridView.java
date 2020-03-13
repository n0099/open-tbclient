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
    private static final int gAG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private View gAH;
    private int gAI;
    private int gAJ;
    private boolean gAK;
    private com.baidu.tieba.frs.game.strategy.view.a gAL;
    private a gAM;
    private int gAN;
    private Drawable gAO;

    /* loaded from: classes9.dex */
    public interface a {
        void i(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gAI = 0;
        this.gAJ = 0;
        this.gAK = true;
        this.gAN = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gAI = 0;
        this.gAJ = 0;
        this.gAK = true;
        this.gAN = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.gAI = 0;
        this.gAJ = 0;
        this.gAK = true;
        this.gAN = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.gAH != null) {
            bR(this.gAH);
        }
        if (this.gAN != 0) {
            this.gAO = am.getDrawable(i, this.gAN);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.gAI = i;
        this.gAJ = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.gAN = i;
        if (this.gAN == 0) {
            this.gAO = am.getDrawable(i);
        } else {
            this.gAO = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.gAH == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.gAH = frameLayout;
        }
        return this.gAH;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void bR(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.gAK) {
                    imageView.setImageDrawable(am.getDrawable(this.gAI));
                } else {
                    imageView.setImageDrawable(am.getDrawable(this.gAJ));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean bHH() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (bHH()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.gAL = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.gAH) {
            if (this.gAL != null && this.gAL.bHJ()) {
                bHI();
            }
        } else if (this.gAM != null && this.gAL != null) {
            int ty = this.gAL.ty(i);
            this.gAL.tx(ty);
            this.gAM.i(ty, this.gAL.getItem(i));
        }
    }

    private void bHI() {
        this.gAK = !this.gAK;
        bR(this.gAH);
        if (this.gAL != null) {
            this.gAL.lQ(this.gAK);
            this.gAL.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.gAK && this.gAO != null) {
            this.gAO.setBounds(0, (height - gAG) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.gAO.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.gAM = aVar;
    }
}
