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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes2.dex */
public class c {
    private TbImageView ePF;
    private View ePG;
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
        this.ePG = this.mView.findViewById(a.g.back_to_come_root);
        this.ePF = (TbImageView) this.mView.findViewById(a.g.back_to_come_logo);
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
                this.ePF.setVisibility(0);
                this.ePF.setAutoChangeStyle(false);
                this.ePF.startLoad(bVar.getImageUrl(), 10, false);
            } else if (bVar.getImageId() != 0) {
                this.ePF.setVisibility(0);
                this.ePF.setImageResource(bVar.getImageId());
            } else {
                this.ePF.setVisibility(8);
            }
            if (!TextUtils.isEmpty(bVar.getTitle())) {
                this.mTitleView.setText(bVar.getTitle());
            } else if (bVar.bhW() != 0) {
                this.mTitleView.setText(bVar.bhW());
            }
            if (!TextUtils.isEmpty(bVar.getScheme())) {
                this.mUrl = bVar.getScheme();
            }
        }
    }

    public void bhX() {
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

    public View bhY() {
        return this.ePG;
    }
}
