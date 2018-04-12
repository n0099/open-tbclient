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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class FoldedGridView extends BdGridView implements AdapterView.OnItemClickListener, f {
    private static final int dhe = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds48);
    private View dhf;
    private int dhg;
    private int dhh;
    private boolean dhi;
    private com.baidu.tieba.frs.game.strategy.view.a dhj;
    private a dhk;
    private int dhl;
    private Drawable dhm;

    /* loaded from: classes3.dex */
    public interface a {
        void c(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dhg = 0;
        this.dhh = 0;
        this.dhi = true;
        this.dhl = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dhg = 0;
        this.dhh = 0;
        this.dhi = true;
        this.dhl = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.dhg = 0;
        this.dhh = 0;
        this.dhi = true;
        this.dhl = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.dhf != null) {
            at(this.dhf);
        }
        if (this.dhl != 0) {
            this.dhm = ak.u(i, this.dhl);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.dhg = i;
        this.dhh = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.dhl = i;
        if (this.dhl == 0) {
            this.dhm = ak.getDrawable(i);
        } else {
            this.dhm = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.dhf == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.dhf = frameLayout;
        }
        return this.dhf;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void at(View view2) {
        if (view2 instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view2;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.dhi) {
                    imageView.setImageDrawable(ak.getDrawable(this.dhg));
                } else {
                    imageView.setImageDrawable(ak.getDrawable(this.dhh));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean asD() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (asD()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.dhj = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        if (view2 == this.dhf) {
            if (this.dhj != null && this.dhj.asF()) {
                asE();
            }
        } else if (this.dhk != null && this.dhj != null) {
            int kK = this.dhj.kK(i);
            this.dhj.kJ(kK);
            this.dhk.c(kK, this.dhj.getItem(i));
        }
    }

    private void asE() {
        this.dhi = !this.dhi;
        at(this.dhf);
        if (this.dhj != null) {
            this.dhj.fM(this.dhi);
            this.dhj.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.dhi && this.dhm != null) {
            this.dhm.setBounds(0, (height - dhe) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.dhm.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.dhk = aVar;
    }
}
