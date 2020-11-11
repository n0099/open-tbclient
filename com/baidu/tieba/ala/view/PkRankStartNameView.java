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
    private TbImageView bKU;
    private TextView hPj;

    public PkRankStartNameView(Context context) {
        super(context);
        init();
    }

    public void setData(String str, String str2) {
        if (this.hPj != null) {
            if (!TextUtils.isEmpty(str) && TextHelper.getTextLengthWithEmoji(str) > 10) {
                str = TextHelper.subStringWithEmoji(str, 10) + StringHelper.STRING_MORE;
            }
            TextView textView = this.hPj;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            textView.setText(str);
        }
        if (this.bKU != null) {
            TbImageView tbImageView = this.bKU;
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            tbImageView.startLoad(str2, 10, false, false);
        }
    }

    public void release() {
        if (this.bKU != null) {
            this.bKU.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(0);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.g.sdk_pk_rank_start_name, (ViewGroup) this, true);
        this.hPj = (TextView) findViewById(a.f.tv_pk_rank_start_nickname);
        this.bKU = (TbImageView) findViewById(a.f.iv_pk_rank_start_level);
        this.bKU.setAutoChangeStyle(false);
        this.bKU.setDefaultBgResource(a.e.pk_rank_division_default);
    }
}
