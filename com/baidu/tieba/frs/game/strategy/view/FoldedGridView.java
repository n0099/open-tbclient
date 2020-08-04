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
/* loaded from: classes16.dex */
public class FoldedGridView extends BdGridView implements AdapterView.OnItemClickListener, f {
    private static final int hTQ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private View hTR;
    private int hTS;
    private int hTT;
    private boolean hTU;
    private com.baidu.tieba.frs.game.strategy.view.a hTV;
    private a hTW;
    private int hTX;
    private Drawable hTY;

    /* loaded from: classes16.dex */
    public interface a {
        void i(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hTS = 0;
        this.hTT = 0;
        this.hTU = true;
        this.hTX = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hTS = 0;
        this.hTT = 0;
        this.hTU = true;
        this.hTX = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.hTS = 0;
        this.hTT = 0;
        this.hTU = true;
        this.hTX = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.hTR != null) {
            cg(this.hTR);
        }
        if (this.hTX != 0) {
            this.hTY = ao.getDrawable(i, this.hTX);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.hTS = i;
        this.hTT = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.hTX = i;
        if (this.hTX == 0) {
            this.hTY = ao.getDrawable(i);
        } else {
            this.hTY = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.hTR == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.hTR = frameLayout;
        }
        return this.hTR;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void cg(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.hTU) {
                    imageView.setImageDrawable(ao.getDrawable(this.hTS));
                } else {
                    imageView.setImageDrawable(ao.getDrawable(this.hTT));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean cfJ() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (cfJ()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.hTV = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.hTR) {
            if (this.hTV != null && this.hTV.cfL()) {
                cfK();
            }
        } else if (this.hTW != null && this.hTV != null) {
            int vG = this.hTV.vG(i);
            this.hTV.vF(vG);
            this.hTW.i(vG, this.hTV.getItem(i));
        }
    }

    private void cfK() {
        this.hTU = !this.hTU;
        cg(this.hTR);
        if (this.hTV != null) {
            this.hTV.ol(this.hTU);
            this.hTV.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.hTU && this.hTY != null) {
            this.hTY.setBounds(0, (height - hTQ) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.hTY.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.hTW = aVar;
    }
}
