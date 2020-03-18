package com.baidu.tieba.ala.liveroom.d;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class c {
    private TbImageView eUt;
    private View eUu;
    private TbPageContext mContext;
    private TextView mTitleView;
    private String mUrl;
    private View mView;

    public c(@NonNull TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        init();
    }

    private void init() {
        this.mView = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.back_to_come_button, (ViewGroup) null);
        this.eUu = this.mView.findViewById(a.g.back_to_come_root);
        this.eUt = (TbImageView) this.mView.findViewById(a.g.back_to_come_logo);
        this.mTitleView = (TextView) this.mView.findViewById(a.g.back_to_come_title);
    }

    private boolean isVisible() {
        return this.mView != null && this.mView.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void show() {
        if (this.mView != null && this.mView.getParent() != null && !isVisible()) {
            this.mView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hide() {
        if (this.mView != null && this.mView.getParent() != null && isVisible()) {
            this.mView.setVisibility(8);
        }
    }

    public void a(b bVar) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.getImageUrl())) {
                this.eUt.setVisibility(0);
                this.eUt.setAutoChangeStyle(false);
                this.eUt.startLoad(bVar.getImageUrl(), 10, false);
            } else if (bVar.getImageId() != 0) {
                this.eUt.setVisibility(0);
                this.eUt.setImageResource(bVar.getImageId());
            } else {
                this.eUt.setVisibility(8);
            }
            if (!TextUtils.isEmpty(bVar.getTitle())) {
                this.mTitleView.setText(bVar.getTitle());
            } else if (bVar.bke() != 0) {
                this.mTitleView.setText(bVar.bke());
            }
            if (!TextUtils.isEmpty(bVar.getScheme())) {
                this.mUrl = bVar.getScheme();
            }
        }
    }

    public void bkf() {
        try {
            if (!TextUtils.isEmpty(this.mUrl) && this.mContext != null) {
                Intent intent = new Intent();
                intent.setData(Uri.parse(this.mUrl));
                intent.setFlags(268435456);
                this.mContext.getPageActivity().startActivity(intent);
            }
        } catch (ActivityNotFoundException e) {
            BdUtilHelper.showToast(this.mContext.getPageActivity(), a.i.ala_back_to_come_error);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View bkg() {
        return this.eUu;
    }
}
