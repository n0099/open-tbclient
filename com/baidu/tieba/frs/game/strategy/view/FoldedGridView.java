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
    private static final int dii = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds48);
    private View dij;
    private int dik;
    private int dil;
    private boolean dim;
    private com.baidu.tieba.frs.game.strategy.view.a din;
    private a dio;
    private int dip;
    private Drawable diq;

    /* loaded from: classes3.dex */
    public interface a {
        void c(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dik = 0;
        this.dil = 0;
        this.dim = true;
        this.dip = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dik = 0;
        this.dil = 0;
        this.dim = true;
        this.dip = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.dik = 0;
        this.dil = 0;
        this.dim = true;
        this.dip = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.dij != null) {
            at(this.dij);
        }
        if (this.dip != 0) {
            this.diq = ak.u(i, this.dip);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.dik = i;
        this.dil = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.dip = i;
        if (this.dip == 0) {
            this.diq = ak.getDrawable(i);
        } else {
            this.diq = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.dij == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.dij = frameLayout;
        }
        return this.dij;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void at(View view2) {
        if (view2 instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view2;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.dim) {
                    imageView.setImageDrawable(ak.getDrawable(this.dik));
                } else {
                    imageView.setImageDrawable(ak.getDrawable(this.dil));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean asC() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (asC()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.din = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        if (view2 == this.dij) {
            if (this.din != null && this.din.asE()) {
                asD();
            }
        } else if (this.dio != null && this.din != null) {
            int kI = this.din.kI(i);
            this.din.kH(kI);
            this.dio.c(kI, this.din.getItem(i));
        }
    }

    private void asD() {
        this.dim = !this.dim;
        at(this.dij);
        if (this.din != null) {
            this.din.fN(this.dim);
            this.din.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.dim && this.diq != null) {
            this.diq.setBounds(0, (height - dii) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.diq.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.dio = aVar;
    }
}
