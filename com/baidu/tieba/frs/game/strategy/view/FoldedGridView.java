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
    private static final int hTO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private View hTP;
    private int hTQ;
    private int hTR;
    private boolean hTS;
    private com.baidu.tieba.frs.game.strategy.view.a hTT;
    private a hTU;
    private int hTV;
    private Drawable hTW;

    /* loaded from: classes16.dex */
    public interface a {
        void i(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hTQ = 0;
        this.hTR = 0;
        this.hTS = true;
        this.hTV = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hTQ = 0;
        this.hTR = 0;
        this.hTS = true;
        this.hTV = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.hTQ = 0;
        this.hTR = 0;
        this.hTS = true;
        this.hTV = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.hTP != null) {
            cg(this.hTP);
        }
        if (this.hTV != 0) {
            this.hTW = ao.getDrawable(i, this.hTV);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.hTQ = i;
        this.hTR = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.hTV = i;
        if (this.hTV == 0) {
            this.hTW = ao.getDrawable(i);
        } else {
            this.hTW = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.hTP == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.hTP = frameLayout;
        }
        return this.hTP;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void cg(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.hTS) {
                    imageView.setImageDrawable(ao.getDrawable(this.hTQ));
                } else {
                    imageView.setImageDrawable(ao.getDrawable(this.hTR));
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
        this.hTT = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.hTP) {
            if (this.hTT != null && this.hTT.cfL()) {
                cfK();
            }
        } else if (this.hTU != null && this.hTT != null) {
            int vG = this.hTT.vG(i);
            this.hTT.vF(vG);
            this.hTU.i(vG, this.hTT.getItem(i));
        }
    }

    private void cfK() {
        this.hTS = !this.hTS;
        cg(this.hTP);
        if (this.hTT != null) {
            this.hTT.ol(this.hTS);
            this.hTT.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.hTS && this.hTW != null) {
            this.hTW.setBounds(0, (height - hTO) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.hTW.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.hTU = aVar;
    }
}
