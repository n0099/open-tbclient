package com.baidu.tieba.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.a.a.b;
/* loaded from: classes.dex */
public abstract class a<T extends com.baidu.tieba.a.a.b> implements View.OnClickListener {
    private Context mContext;
    private String mFrom;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    private View mView = LayoutInflater.from(getContext()).inflate(Ip(), (ViewGroup) null, false);

    public abstract int Ip();

    public a(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
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

    public TbPageContext<?> Io() {
        return this.mTbPageContext;
    }
}
