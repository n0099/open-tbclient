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
    private static final int gBE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private View gBF;
    private int gBG;
    private int gBH;
    private boolean gBI;
    private com.baidu.tieba.frs.game.strategy.view.a gBJ;
    private a gBK;
    private int gBL;
    private Drawable gBM;

    /* loaded from: classes9.dex */
    public interface a {
        void i(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gBG = 0;
        this.gBH = 0;
        this.gBI = true;
        this.gBL = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gBG = 0;
        this.gBH = 0;
        this.gBI = true;
        this.gBL = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.gBG = 0;
        this.gBH = 0;
        this.gBI = true;
        this.gBL = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.gBF != null) {
            bR(this.gBF);
        }
        if (this.gBL != 0) {
            this.gBM = am.getDrawable(i, this.gBL);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.gBG = i;
        this.gBH = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.gBL = i;
        if (this.gBL == 0) {
            this.gBM = am.getDrawable(i);
        } else {
            this.gBM = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.gBF == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.gBF = frameLayout;
        }
        return this.gBF;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void bR(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.gBI) {
                    imageView.setImageDrawable(am.getDrawable(this.gBG));
                } else {
                    imageView.setImageDrawable(am.getDrawable(this.gBH));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean bHT() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (bHT()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.gBJ = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.gBF) {
            if (this.gBJ != null && this.gBJ.bHV()) {
                bHU();
            }
        } else if (this.gBK != null && this.gBJ != null) {
            int tE = this.gBJ.tE(i);
            this.gBJ.tD(tE);
            this.gBK.i(tE, this.gBJ.getItem(i));
        }
    }

    private void bHU() {
        this.gBI = !this.gBI;
        bR(this.gBF);
        if (this.gBJ != null) {
            this.gBJ.lV(this.gBI);
            this.gBJ.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.gBI && this.gBM != null) {
            this.gBM.setBounds(0, (height - gBE) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.gBM.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.gBK = aVar;
    }
}
