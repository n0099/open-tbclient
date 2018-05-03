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
    private static final int dhb = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds48);
    private View dhc;
    private int dhd;
    private int dhe;
    private boolean dhf;
    private com.baidu.tieba.frs.game.strategy.view.a dhg;
    private a dhh;
    private int dhi;
    private Drawable dhj;

    /* loaded from: classes3.dex */
    public interface a {
        void c(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dhd = 0;
        this.dhe = 0;
        this.dhf = true;
        this.dhi = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dhd = 0;
        this.dhe = 0;
        this.dhf = true;
        this.dhi = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.dhd = 0;
        this.dhe = 0;
        this.dhf = true;
        this.dhi = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.dhc != null) {
            at(this.dhc);
        }
        if (this.dhi != 0) {
            this.dhj = ak.u(i, this.dhi);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.dhd = i;
        this.dhe = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.dhi = i;
        if (this.dhi == 0) {
            this.dhj = ak.getDrawable(i);
        } else {
            this.dhj = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.dhc == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.dhc = frameLayout;
        }
        return this.dhc;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void at(View view2) {
        if (view2 instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view2;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.dhf) {
                    imageView.setImageDrawable(ak.getDrawable(this.dhd));
                } else {
                    imageView.setImageDrawable(ak.getDrawable(this.dhe));
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
        this.dhg = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        if (view2 == this.dhc) {
            if (this.dhg != null && this.dhg.asF()) {
                asE();
            }
        } else if (this.dhh != null && this.dhg != null) {
            int kJ = this.dhg.kJ(i);
            this.dhg.kI(kJ);
            this.dhh.c(kJ, this.dhg.getItem(i));
        }
    }

    private void asE() {
        this.dhf = !this.dhf;
        at(this.dhc);
        if (this.dhg != null) {
            this.dhg.fM(this.dhf);
            this.dhg.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.dhf && this.dhj != null) {
            this.dhj.setBounds(0, (height - dhb) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.dhj.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.dhh = aVar;
    }
}
