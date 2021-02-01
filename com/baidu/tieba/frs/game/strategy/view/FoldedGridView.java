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
/* loaded from: classes2.dex */
public class FoldedGridView extends BdGridView implements AdapterView.OnItemClickListener, e {
    private static final int jyd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private View jye;
    private int jyf;
    private int jyg;
    private boolean jyh;
    private com.baidu.tieba.frs.game.strategy.view.a jyi;
    private a jyj;
    private int jyk;
    private Drawable jyl;

    /* loaded from: classes2.dex */
    public interface a {
        void l(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jyf = 0;
        this.jyg = 0;
        this.jyh = true;
        this.jyk = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jyf = 0;
        this.jyg = 0;
        this.jyh = true;
        this.jyk = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.jyf = 0;
        this.jyg = 0;
        this.jyh = true;
        this.jyk = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.jye != null) {
            cX(this.jye);
        }
        if (this.jyk != 0) {
            this.jyl = ap.getDrawable(i, this.jyk);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.jyf = i;
        this.jyg = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.jyk = i;
        if (this.jyk == 0) {
            this.jyl = ap.getDrawable(i);
        } else {
            this.jyl = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.e
    public View getArrowView() {
        if (this.jye == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.jye = frameLayout;
        }
        return this.jye;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.e
    public void cX(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.jyh) {
                    imageView.setImageDrawable(ap.getDrawable(this.jyf));
                } else {
                    imageView.setImageDrawable(ap.getDrawable(this.jyg));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.e
    public boolean cHT() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.e
    public int getArrowIndex() {
        if (cHT()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.jyi = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.jye) {
            if (this.jyi != null && this.jyi.cHV()) {
                cHU();
            }
        } else if (this.jyj != null && this.jyi != null) {
            int zM = this.jyi.zM(i);
            this.jyi.zL(zM);
            this.jyj.l(zM, this.jyi.getItem(i));
        }
    }

    private void cHU() {
        this.jyh = !this.jyh;
        cX(this.jye);
        if (this.jyi != null) {
            this.jyi.rl(this.jyh);
            this.jyi.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.jyh && this.jyl != null) {
            this.jyl.setBounds(0, (height - jyd) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.jyl.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.jyj = aVar;
    }
}
