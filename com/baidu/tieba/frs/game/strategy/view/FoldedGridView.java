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
/* loaded from: classes6.dex */
public class FoldedGridView extends BdGridView implements AdapterView.OnItemClickListener, f {
    private static final int gvi = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private View gvj;
    private int gvk;
    private int gvl;
    private boolean gvm;
    private com.baidu.tieba.frs.game.strategy.view.a gvn;
    private a gvo;
    private int gvp;
    private Drawable gvq;

    /* loaded from: classes6.dex */
    public interface a {
        void i(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gvk = 0;
        this.gvl = 0;
        this.gvm = true;
        this.gvp = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gvk = 0;
        this.gvl = 0;
        this.gvm = true;
        this.gvp = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.gvk = 0;
        this.gvl = 0;
        this.gvm = true;
        this.gvp = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.gvj != null) {
            bM(this.gvj);
        }
        if (this.gvp != 0) {
            this.gvq = am.getDrawable(i, this.gvp);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.gvk = i;
        this.gvl = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.gvp = i;
        if (this.gvp == 0) {
            this.gvq = am.getDrawable(i);
        } else {
            this.gvq = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.gvj == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.gvj = frameLayout;
        }
        return this.gvj;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void bM(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.gvm) {
                    imageView.setImageDrawable(am.getDrawable(this.gvk));
                } else {
                    imageView.setImageDrawable(am.getDrawable(this.gvl));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean bFa() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (bFa()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.gvn = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.gvj) {
            if (this.gvn != null && this.gvn.bFc()) {
                bFb();
            }
        } else if (this.gvo != null && this.gvn != null) {
            int tn = this.gvn.tn(i);
            this.gvn.tm(tn);
            this.gvo.i(tn, this.gvn.getItem(i));
        }
    }

    private void bFb() {
        this.gvm = !this.gvm;
        bM(this.gvj);
        if (this.gvn != null) {
            this.gvn.lC(this.gvm);
            this.gvn.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.gvm && this.gvq != null) {
            this.gvq.setBounds(0, (height - gvi) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.gvq.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.gvo = aVar;
    }
}
