package com.baidu.tieba.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.a.b;
/* loaded from: classes.dex */
public abstract class a<T extends com.baidu.tieba.card.a.b> implements View.OnClickListener {
    private String Zw;
    private bx<T> aRn;
    private Context mContext;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    private BdUniqueId mTag = null;
    private View mView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null, false);

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
        return this.Zw;
    }

    public void setFrom(String str) {
        this.Zw = str;
    }

    public View getView() {
        return this.mView;
    }

    public Context getContext() {
        return this.mContext;
    }

    public TbPageContext<?> KN() {
        return this.mTbPageContext;
    }

    public void a(bx<T> bxVar) {
        this.aRn = bxVar;
    }

    public bx<T> KO() {
        return this.aRn;
    }
}
