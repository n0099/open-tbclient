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
/* loaded from: classes2.dex */
public class FoldedGridView extends BdGridView implements AdapterView.OnItemClickListener, e {
    private static final int jsx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private int jsA;
    private boolean jsB;
    private com.baidu.tieba.frs.game.strategy.view.a jsC;
    private a jsD;
    private int jsE;
    private Drawable jsF;
    private View jsy;
    private int jsz;

    /* loaded from: classes2.dex */
    public interface a {
        void l(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jsz = 0;
        this.jsA = 0;
        this.jsB = true;
        this.jsE = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jsz = 0;
        this.jsA = 0;
        this.jsB = true;
        this.jsE = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.jsz = 0;
        this.jsA = 0;
        this.jsB = true;
        this.jsE = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.jsy != null) {
            cZ(this.jsy);
        }
        if (this.jsE != 0) {
            this.jsF = ao.getDrawable(i, this.jsE);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.jsz = i;
        this.jsA = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.jsE = i;
        if (this.jsE == 0) {
            this.jsF = ao.getDrawable(i);
        } else {
            this.jsF = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.e
    public View getArrowView() {
        if (this.jsy == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.jsy = frameLayout;
        }
        return this.jsy;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.e
    public void cZ(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.jsB) {
                    imageView.setImageDrawable(ao.getDrawable(this.jsz));
                } else {
                    imageView.setImageDrawable(ao.getDrawable(this.jsA));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.e
    public boolean cGG() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.e
    public int getArrowIndex() {
        if (cGG()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.jsC = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.jsy) {
            if (this.jsC != null && this.jsC.cGI()) {
                cGH();
            }
        } else if (this.jsD != null && this.jsC != null) {
            int zC = this.jsC.zC(i);
            this.jsC.zB(zC);
            this.jsD.l(zC, this.jsC.getItem(i));
        }
    }

    private void cGH() {
        this.jsB = !this.jsB;
        cZ(this.jsy);
        if (this.jsC != null) {
            this.jsC.rb(this.jsB);
            this.jsC.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.jsB && this.jsF != null) {
            this.jsF.setBounds(0, (height - jsx) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.jsF.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.jsD = aVar;
    }
}
