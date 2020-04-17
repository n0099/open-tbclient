package com.baidu.tieba.ala.liveroom.s;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class b {
    private TextView fOX;
    private TbPageContext mContext;
    private View mView;

    public b(TbPageContext tbPageContext, AlaLiveUserInfoData alaLiveUserInfoData, View.OnClickListener onClickListener) {
        this.mContext = tbPageContext;
        a(this.mContext, alaLiveUserInfoData, onClickListener);
    }

    private void a(TbPageContext tbPageContext, AlaLiveUserInfoData alaLiveUserInfoData, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(a.h.guide_rename_view_layout, (ViewGroup) null);
        this.fOX = (TextView) this.mView.findViewById(a.g.guide_rename_txt);
        this.fOX.setText(b(alaLiveUserInfoData));
        this.mView.setOnClickListener(onClickListener);
    }

    public SpannableStringBuilder b(AlaLiveUserInfoData alaLiveUserInfoData) {
        String str;
        int length;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (alaLiveUserInfoData != null && alaLiveUserInfoData.userName != null) {
            if (alaLiveUserInfoData.userName.length() > 8) {
                str = alaLiveUserInfoData.userName.substring(0, 7) + StringHelper.STRING_MORE;
                length = str.length() + 3;
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
