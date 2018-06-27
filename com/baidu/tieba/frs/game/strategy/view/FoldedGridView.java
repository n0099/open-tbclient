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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class FoldedGridView extends BdGridView implements AdapterView.OnItemClickListener, f {
    private static final int duG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds48);
    private View duH;
    private int duI;
    private int duJ;
    private boolean duK;
    private com.baidu.tieba.frs.game.strategy.view.a duL;
    private a duM;
    private int duN;
    private Drawable duO;

    /* loaded from: classes3.dex */
    public interface a {
        void c(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.duI = 0;
        this.duJ = 0;
        this.duK = true;
        this.duN = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.duI = 0;
        this.duJ = 0;
        this.duK = true;
        this.duN = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.duI = 0;
        this.duJ = 0;
        this.duK = true;
        this.duN = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.duH != null) {
            av(this.duH);
        }
        if (this.duN != 0) {
            this.duO = am.v(i, this.duN);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.duI = i;
        this.duJ = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.duN = i;
        if (this.duN == 0) {
            this.duO = am.getDrawable(i);
        } else {
            this.duO = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.duH == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.duH = frameLayout;
        }
        return this.duH;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void av(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.duK) {
                    imageView.setImageDrawable(am.getDrawable(this.duI));
                } else {
                    imageView.setImageDrawable(am.getDrawable(this.duJ));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean axm() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (axm()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.duL = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.duH) {
            if (this.duL != null && this.duL.axo()) {
                axn();
            }
        } else if (this.duM != null && this.duL != null) {
            int kU = this.duL.kU(i);
            this.duL.kT(kU);
            this.duM.c(kU, this.duL.getItem(i));
        }
    }

    private void axn() {
        this.duK = !this.duK;
        av(this.duH);
        if (this.duL != null) {
            this.duL.ga(this.duK);
            this.duL.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.duK && this.duO != null) {
            this.duO.setBounds(0, (height - duG) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.duO.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.duM = aVar;
    }
}
