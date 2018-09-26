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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class FoldedGridView extends BdGridView implements AdapterView.OnItemClickListener, f {
    private static final int dEa = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds48);
    private View dEb;
    private int dEc;
    private int dEd;
    private boolean dEe;
    private com.baidu.tieba.frs.game.strategy.view.a dEf;
    private a dEg;
    private int dEh;
    private Drawable dEi;

    /* loaded from: classes3.dex */
    public interface a {
        void c(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dEc = 0;
        this.dEd = 0;
        this.dEe = true;
        this.dEh = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dEc = 0;
        this.dEd = 0;
        this.dEe = true;
        this.dEh = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.dEc = 0;
        this.dEd = 0;
        this.dEe = true;
        this.dEh = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.dEb != null) {
            aM(this.dEb);
        }
        if (this.dEh != 0) {
            this.dEi = al.x(i, this.dEh);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.dEc = i;
        this.dEd = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.dEh = i;
        if (this.dEh == 0) {
            this.dEi = al.getDrawable(i);
        } else {
            this.dEi = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.dEb == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.dEb = frameLayout;
        }
        return this.dEb;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void aM(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.dEe) {
                    imageView.setImageDrawable(al.getDrawable(this.dEc));
                } else {
                    imageView.setImageDrawable(al.getDrawable(this.dEd));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean aAe() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (aAe()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.dEf = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.dEb) {
            if (this.dEf != null && this.dEf.aAg()) {
                aAf();
            }
        } else if (this.dEg != null && this.dEf != null) {
            int lH = this.dEf.lH(i);
            this.dEf.lG(lH);
            this.dEg.c(lH, this.dEf.getItem(i));
        }
    }

    private void aAf() {
        this.dEe = !this.dEe;
        aM(this.dEb);
        if (this.dEf != null) {
            this.dEf.gA(this.dEe);
            this.dEf.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.dEe && this.dEi != null) {
            this.dEi.setBounds(0, (height - dEa) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.dEi.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.dEg = aVar;
    }
}
