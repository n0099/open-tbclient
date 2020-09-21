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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class FoldedGridView extends BdGridView implements AdapterView.OnItemClickListener, f {
    private static final int ipf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private View ipg;
    private int iph;
    private int ipi;
    private boolean ipj;
    private com.baidu.tieba.frs.game.strategy.view.a ipk;
    private a ipl;
    private int ipm;
    private Drawable ipn;

    /* loaded from: classes21.dex */
    public interface a {
        void i(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iph = 0;
        this.ipi = 0;
        this.ipj = true;
        this.ipm = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iph = 0;
        this.ipi = 0;
        this.ipj = true;
        this.ipm = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.iph = 0;
        this.ipi = 0;
        this.ipj = true;
        this.ipm = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.ipg != null) {
            cr(this.ipg);
        }
        if (this.ipm != 0) {
            this.ipn = ap.getDrawable(i, this.ipm);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.iph = i;
        this.ipi = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.ipm = i;
        if (this.ipm == 0) {
            this.ipn = ap.getDrawable(i);
        } else {
            this.ipn = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.ipg == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.ipg = frameLayout;
        }
        return this.ipg;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void cr(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.ipj) {
                    imageView.setImageDrawable(ap.getDrawable(this.iph));
                } else {
                    imageView.setImageDrawable(ap.getDrawable(this.ipi));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean ctC() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (ctC()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.ipk = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.ipg) {
            if (this.ipk != null && this.ipk.ctE()) {
                ctD();
            }
        } else if (this.ipl != null && this.ipk != null) {
            int yy = this.ipk.yy(i);
            this.ipk.yx(yy);
            this.ipl.i(yy, this.ipk.getItem(i));
        }
    }

    private void ctD() {
        this.ipj = !this.ipj;
        cr(this.ipg);
        if (this.ipk != null) {
            this.ipk.oX(this.ipj);
            this.ipk.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.ipj && this.ipn != null) {
            this.ipn.setBounds(0, (height - ipf) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.ipn.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.ipl = aVar;
    }
}
