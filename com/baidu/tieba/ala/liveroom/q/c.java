package com.baidu.tieba.ala.liveroom.q;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes6.dex */
public class c {
    private TextView enk;
    private TbPageContext mContext;
    private View mView;

    public c(TbPageContext tbPageContext, AlaLiveUserInfoData alaLiveUserInfoData, View.OnClickListener onClickListener) {
        this.mContext = tbPageContext;
        a(this.mContext, alaLiveUserInfoData, onClickListener);
    }

    private void a(TbPageContext tbPageContext, AlaLiveUserInfoData alaLiveUserInfoData, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(a.h.guide_rename_view_layout, (ViewGroup) null);
        this.enk = (TextView) this.mView.findViewById(a.g.guide_rename_txt);
        this.enk.setText(a(alaLiveUserInfoData));
        this.mView.setOnClickListener(onClickListener);
    }

    public SpannableStringBuilder a(AlaLiveUserInfoData alaLiveUserInfoData) {
        String str;
        int length;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (alaLiveUserInfoData != null && alaLiveUserInfoData.userName != null) {
            if (alaLiveUserInfoData.userName.length() > 8) {
                str = alaLiveUserInfoData.userName.substring(0, 8);
                length = 11;
            } else {
                str = alaLiveUserInfoData.userName;
                length = alaLiveUserInfoData.userName.length() + 3;
            }
            spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.guide_rename_str), str));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#F7E51B")), 3, length, 34);
        }
        return spannableStringBuilder;
    }

    public View getView() {
        return this.mView;
    }
}
