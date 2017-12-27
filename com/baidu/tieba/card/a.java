package com.baidu.tieba.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.b;
/* loaded from: classes.dex */
public abstract class a<T extends com.baidu.tieba.card.data.b> implements View.OnClickListener {
    protected v<T> cNC;
    public int currentPageType;
    public Context mContext;
    private String mFrom;
    public TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    private BdUniqueId mTag = null;
    private View mView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null, false);

    public abstract void a(T t);

    public abstract void d(TbPageContext<?> tbPageContext, int i);

    public abstract int getLayout();

    public a(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
    }

    public BdUniqueId getTag() {
        return this.mTag;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public View getView() {
        return this.mView;
    }

    public Context getContext() {
        return this.mContext;
    }

    public TbPageContext<?> aiX() {
        return this.mTbPageContext;
    }

    public void onDestroy() {
    }

    public void setVisibility(int i) {
        if (this.mView != null) {
            this.mView.setVisibility(i);
        }
    }

    public void b(v<T> vVar) {
        this.cNC = vVar;
    }

    public v<T> aiY() {
        return this.cNC;
    }
}
