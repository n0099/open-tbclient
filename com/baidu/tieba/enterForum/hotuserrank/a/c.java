package com.baidu.tieba.enterForum.hotuserrank.a;

import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;
import tbclient.GetInfluenceRank.DataRes;
import tbclient.User;
/* loaded from: classes22.dex */
public class c {
    public String gEm;
    public long igg;
    public a ign;
    public b igp;
    public String igq;
    public List<b> igo = new ArrayList();
    public boolean hasMore = true;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.ign = new a();
            if (!y.isEmpty(dataRes.user_rank) && dataRes.user_rank.get(0) != null) {
                this.ign.ige = b(dataRes.user_rank.get(0));
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(dataRes.user_rank.get(0));
                this.ign.igf = metaData;
                String avatarH = metaData.getAvatarH();
                if (TextUtils.isEmpty(avatarH)) {
                    avatarH = metaData.getAvater();
                }
                if (avatarH != null && avatarH.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.ign.igh = avatarH;
                } else {
                    this.ign.igh = "http://tb.himg.baidu.com/sys/portraith/item/" + avatarH;
                }
            }
            this.ign.igg = dataRes.timestamp == null ? 0L : dataRes.timestamp.longValue();
            this.ign.igi = dataRes.field_info;
            if (!y.isEmpty(dataRes.user_rank)) {
                for (User user : dataRes.user_rank) {
                    if (user != null) {
                        this.igo.add(a(user));
                    }
                }
            }
            this.igp = a(dataRes.current_user);
            if (dataRes.rank_description != null) {
                this.gEm = dataRes.rank_description.top_link;
                this.igq = dataRes.rank_description.bottom_link;
            }
            this.igg = dataRes.timestamp != null ? dataRes.timestamp.longValue() : 0L;
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
            bVar.igj = user.baijiahao_info.auth_desc;
            Integer num = user.baijiahao_info.auth_id;
            bVar.igm = (num == null || num.intValue() == 0) ? false : true;
        }
        if (!bVar.igm && user.new_god_data != null && user.new_god_data.status.intValue() == 3) {
            bVar.igj = user.new_god_data.field_name + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
            bVar.igb = true;
        }
        if (user.influence == null) {
            bVar.igk = "";
        } else {
            bVar.igk = String.format(TbadkCoreApplication.getInst().getString(R.string.influence), at.numFormatOverWanNa(user.influence.intValue()));
        }
        MetaData metaData = new MetaData();
        metaData.parserProtobuf(user);
        if (user.has_concerned == null || user.has_concerned.intValue() == 0) {
            z = false;
        }
        metaData.setIsLike(z);
        bVar.igl = metaData;
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
