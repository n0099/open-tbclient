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
/* loaded from: classes4.dex */
public class FoldedGridView extends BdGridView implements AdapterView.OnItemClickListener, f {
    private static final int fHG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private View fHH;
    private int fHI;
    private int fHJ;
    private boolean fHK;
    private com.baidu.tieba.frs.game.strategy.view.a fHL;
    private a fHM;
    private int fHN;
    private Drawable fHO;

    /* loaded from: classes4.dex */
    public interface a {
        void i(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fHI = 0;
        this.fHJ = 0;
        this.fHK = true;
        this.fHN = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fHI = 0;
        this.fHJ = 0;
        this.fHK = true;
        this.fHN = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.fHI = 0;
        this.fHJ = 0;
        this.fHK = true;
        this.fHN = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.fHH != null) {
            bR(this.fHH);
        }
        if (this.fHN != 0) {
            this.fHO = am.getDrawable(i, this.fHN);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.fHI = i;
        this.fHJ = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.fHN = i;
        if (this.fHN == 0) {
            this.fHO = am.getDrawable(i);
        } else {
            this.fHO = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.fHH == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.fHH = frameLayout;
        }
        return this.fHH;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void bR(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.fHK) {
                    imageView.setImageDrawable(am.getDrawable(this.fHI));
                } else {
                    imageView.setImageDrawable(am.getDrawable(this.fHJ));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean bnF() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (bnF()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.fHL = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.fHH) {
            if (this.fHL != null && this.fHL.bnH()) {
                bnG();
            }
        } else if (this.fHM != null && this.fHL != null) {
            int ri = this.fHL.ri(i);
            this.fHL.rh(ri);
            this.fHM.i(ri, this.fHL.getItem(i));
        }
    }

    private void bnG() {
        this.fHK = !this.fHK;
        bR(this.fHH);
        if (this.fHL != null) {
            this.fHL.kq(this.fHK);
            this.fHL.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.fHK && this.fHO != null) {
            this.fHO.setBounds(0, (height - fHG) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.fHO.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.fHM = aVar;
    }
}
