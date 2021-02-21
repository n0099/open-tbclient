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
    private static final int jyr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private View jys;
    private int jyt;
    private int jyu;
    private boolean jyv;
    private com.baidu.tieba.frs.game.strategy.view.a jyw;
    private a jyx;
    private int jyy;
    private Drawable jyz;

    /* loaded from: classes2.dex */
    public interface a {
        void l(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jyt = 0;
        this.jyu = 0;
        this.jyv = true;
        this.jyy = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jyt = 0;
        this.jyu = 0;
        this.jyv = true;
        this.jyy = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.jyt = 0;
        this.jyu = 0;
        this.jyv = true;
        this.jyy = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.jys != null) {
            cX(this.jys);
        }
        if (this.jyy != 0) {
            this.jyz = ap.getDrawable(i, this.jyy);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.jyt = i;
        this.jyu = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.jyy = i;
        if (this.jyy == 0) {
            this.jyz = ap.getDrawable(i);
        } else {
            this.jyz = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.e
    public View getArrowView() {
        if (this.jys == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.jys = frameLayout;
        }
        return this.jys;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.e
    public void cX(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.jyv) {
                    imageView.setImageDrawable(ap.getDrawable(this.jyt));
                } else {
                    imageView.setImageDrawable(ap.getDrawable(this.jyu));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.e
    public boolean cIa() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.e
    public int getArrowIndex() {
        if (cIa()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.jyw = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.jys) {
            if (this.jyw != null && this.jyw.cIc()) {
                cIb();
            }
        } else if (this.jyx != null && this.jyw != null) {
            int zM = this.jyw.zM(i);
            this.jyw.zL(zM);
            this.jyx.l(zM, this.jyw.getItem(i));
        }
    }

    private void cIb() {
        this.jyv = !this.jyv;
        cX(this.jys);
        if (this.jyw != null) {
            this.jyw.rl(this.jyv);
            this.jyw.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.jyv && this.jyz != null) {
            this.jyz.setBounds(0, (height - jyr) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.jyz.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.jyx = aVar;
    }
}
