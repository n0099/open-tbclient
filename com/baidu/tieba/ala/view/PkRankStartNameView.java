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
    private TbImageView gDq;
    private TextView hJm;

    public PkRankStartNameView(Context context) {
        super(context);
        init();
    }

    public void setData(String str, String str2) {
        if (this.hJm != null) {
            if (!TextUtils.isEmpty(str) && TextHelper.getTextLengthWithEmoji(str) > 10) {
                str = TextHelper.subStringWithEmoji(str, 10) + StringHelper.STRING_MORE;
            }
            TextView textView = this.hJm;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            textView.setText(str);
        }
        if (this.gDq != null) {
            TbImageView tbImageView = this.gDq;
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            tbImageView.startLoad(str2, 10, false, false);
        }
    }

    public void release() {
        if (this.gDq != null) {
            this.gDq.stopLoad();
        }
    }

    private void init() {
        setBackgroundColor(0);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.sdk_pk_rank_start_name, (ViewGroup) this, true);
        this.hJm = (TextView) findViewById(a.g.tv_pk_rank_start_nickname);
        this.gDq = (TbImageView) findViewById(a.g.iv_pk_rank_start_level);
        this.gDq.setAutoChangeStyle(false);
        this.gDq.setDefaultBgResource(a.f.pk_rank_division_default);
    }
}
