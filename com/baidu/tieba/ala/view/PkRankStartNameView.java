package com.baidu.tieba.ala.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class PkRankStartNameView extends LinearLayout {
    private TbImageView gtm;
    private TextView hwP;

    public PkRankStartNameView(Context context) {
        super(context);
        init();
    }

    public void setData(String str, String str2) {
        if (this.hwP != null) {
            if (!TextUtils.isEmpty(str) && TextHelper.getTextLengthWithEmoji(str) > 10) {
                str = TextHelper.subStringWithEmoji(str, 10) + StringHelper.STRING_MORE;
            }
            TextView textView = this.hwP;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            textView.setText(str);
        }
        if (this.gtm != null) {
            TbImageView tbImageView = this.gtm;
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            tbImageView.startLoad(str2, 10, false, false);
        }
    }

    public void release() {
        if (this.gtm != null) {
            this.gtm.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(0);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.sdk_pk_rank_start_name, (ViewGroup) this, true);
        this.hwP = (TextView) findViewById(a.g.tv_pk_rank_start_nickname);
        this.gtm = (TbImageView) findViewById(a.g.iv_pk_rank_start_level);
        this.gtm.setAutoChangeStyle(false);
        this.gtm.setDefaultBgResource(a.f.pk_rank_division_default);
    }
}
