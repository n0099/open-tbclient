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
/* loaded from: classes10.dex */
public class PkRankStartNameView extends LinearLayout {
    private TbImageView bOt;
    private TextView ihB;

    public PkRankStartNameView(Context context) {
        super(context);
        init();
    }

    public void setData(String str, String str2) {
        if (this.ihB != null) {
            if (!TextUtils.isEmpty(str) && TextHelper.getTextLengthWithEmoji(str) > 10) {
                str = TextHelper.subStringWithEmoji(str, 10) + StringHelper.STRING_MORE;
            }
            TextView textView = this.ihB;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            textView.setText(str);
        }
        if (this.bOt != null) {
            TbImageView tbImageView = this.bOt;
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            tbImageView.startLoad(str2, 10, false, false);
        }
    }

    public void release() {
        if (this.bOt != null) {
            this.bOt.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(0);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.g.sdk_pk_rank_start_name, (ViewGroup) this, true);
        this.ihB = (TextView) findViewById(a.f.tv_pk_rank_start_nickname);
        this.bOt = (TbImageView) findViewById(a.f.iv_pk_rank_start_level);
        this.bOt.setAutoChangeStyle(false);
        this.bOt.setDefaultBgResource(a.e.pk_rank_division_default);
    }
}
