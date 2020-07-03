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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class FoldedGridView extends BdGridView implements AdapterView.OnItemClickListener, f {
    private static final int hNP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private View hNQ;
    private int hNR;
    private int hNS;
    private boolean hNT;
    private com.baidu.tieba.frs.game.strategy.view.a hNU;
    private a hNV;
    private int hNW;
    private Drawable hNX;

    /* loaded from: classes9.dex */
    public interface a {
        void i(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hNR = 0;
        this.hNS = 0;
        this.hNT = true;
        this.hNW = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hNR = 0;
        this.hNS = 0;
        this.hNT = true;
        this.hNW = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.hNR = 0;
        this.hNS = 0;
        this.hNT = true;
        this.hNW = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.hNQ != null) {
            ca(this.hNQ);
        }
        if (this.hNW != 0) {
            this.hNX = an.getDrawable(i, this.hNW);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.hNR = i;
        this.hNS = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.hNW = i;
        if (this.hNW == 0) {
            this.hNX = an.getDrawable(i);
        } else {
            this.hNX = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.hNQ == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.hNQ = frameLayout;
        }
        return this.hNQ;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void ca(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.hNT) {
                    imageView.setImageDrawable(an.getDrawable(this.hNR));
                } else {
                    imageView.setImageDrawable(an.getDrawable(this.hNS));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean cck() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (cck()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.hNU = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.hNQ) {
            if (this.hNU != null && this.hNU.ccm()) {
                ccl();
            }
        } else if (this.hNV != null && this.hNU != null) {
            int vo = this.hNU.vo(i);
            this.hNU.vn(vo);
            this.hNV.i(vo, this.hNU.getItem(i));
        }
    }

    private void ccl() {
        this.hNT = !this.hNT;
        ca(this.hNQ);
        if (this.hNU != null) {
            this.hNU.nG(this.hNT);
            this.hNU.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.hNT && this.hNX != null) {
            this.hNX.setBounds(0, (height - hNP) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.hNX.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.hNV = aVar;
    }
}
