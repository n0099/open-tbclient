package com.baidu.tieba.enterForum.hotuserrank.a;

import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.util.ag;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;
import tbclient.GetInfluenceRank.DataRes;
import tbclient.User;
/* loaded from: classes2.dex */
public class c {
    public String heG;
    public long iKa;
    public a iKh;
    public b iKj;
    public String iKk;
    public List<b> iKi = new ArrayList();
    public boolean hasMore = true;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iKh = new a();
            if (!x.isEmpty(dataRes.user_rank) && dataRes.user_rank.get(0) != null) {
                this.iKh.iJY = b(dataRes.user_rank.get(0));
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(dataRes.user_rank.get(0));
                this.iKh.iJZ = metaData;
                String avatarH = metaData.getAvatarH();
                if (TextUtils.isEmpty(avatarH)) {
                    avatarH = metaData.getAvater();
                }
                if (avatarH != null && avatarH.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.iKh.iKb = avatarH;
                } else {
                    this.iKh.iKb = "http://tb.himg.baidu.com/sys/portraith/item/" + avatarH;
                }
            }
            this.iKh.iKa = dataRes.timestamp == null ? 0L : dataRes.timestamp.longValue();
            this.iKh.iKc = dataRes.field_info;
            if (!x.isEmpty(dataRes.user_rank)) {
                for (User user : dataRes.user_rank) {
                    if (user != null) {
                        this.iKi.add(a(user));
                    }
                }
            }
            this.iKj = a(dataRes.current_user);
            if (dataRes.rank_description != null) {
                this.heG = dataRes.rank_description.top_link;
                this.iKk = dataRes.rank_description.bottom_link;
            }
            this.iKa = dataRes.timestamp != null ? dataRes.timestamp.longValue() : 0L;
            this.hasMore = dataRes.has_more == null ? false : dataRes.has_more.booleanValue();
        }
    }

    private b a(User user) {
        boolean z = true;
        if (user == null) {
            return null;
        }
        b bVar = new b();
        bVar.rankNum = user.level_influence;
        bVar.userName = b(user);
        if (user.baijiahao_info != null) {
            bVar.iKd = user.baijiahao_info.auth_desc;
            Integer num = user.baijiahao_info.auth_id;
            bVar.iKg = (num == null || num.intValue() == 0) ? false : true;
        }
        if (!bVar.iKg && user.new_god_data != null && user.new_god_data.status.intValue() == 3) {
            bVar.iKd = user.new_god_data.field_name + ag.a(user.new_god_data);
            bVar.iJV = true;
        }
        if (user.influence == null) {
            bVar.iKe = "";
        } else {
            bVar.iKe = String.format(TbadkCoreApplication.getInst().getString(R.string.influence), at.numFormatOverWanNa(user.influence.intValue()));
        }
        MetaData metaData = new MetaData();
        metaData.parserProtobuf(user);
        if (user.has_concerned == null || user.has_concerned.intValue() == 0) {
            z = false;
        }
        metaData.setIsLike(z);
        bVar.iKf = metaData;
        if (metaData.getAvater() != null && metaData.getAvater().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            bVar.headUrl = metaData.getAvater();
        } else {
            bVar.headUrl = TbConfig.getPhotoSmallAddress() + metaData.getAvater();
        }
        return bVar;
    }

    private String b(User user) {
        if (user == null) {
            return "";
        }
        String str = "";
        if (user.baijiahao_info != null) {
            str = user.baijiahao_info.name;
        }
        if (TextUtils.isEmpty(str)) {
            str = user.name_show;
        }
        if (TextUtils.isEmpty(str)) {
            return TbadkCoreApplication.getInst().getString(R.string.user_name_default_txt);
        }
        return str;
    }
}
