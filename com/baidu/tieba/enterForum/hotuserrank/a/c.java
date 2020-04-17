package com.baidu.tieba.enterForum.hotuserrank.a;

import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;
import tbclient.GetInfluenceRank.DataRes;
import tbclient.User;
/* loaded from: classes9.dex */
public class c {
    public String foa;
    public b gDB;
    public String gDC;
    public long gDr;
    public a gDz;
    public List<b> gDA = new ArrayList();
    public boolean hasMore = true;

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.gDz = new a();
            if (!v.isEmpty(dataRes.user_rank) && dataRes.user_rank.get(0) != null) {
                this.gDz.gDp = b(dataRes.user_rank.get(0));
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(dataRes.user_rank.get(0));
                this.gDz.gDq = metaData;
                String avatarH = metaData.getAvatarH();
                if (TextUtils.isEmpty(avatarH)) {
                    avatarH = metaData.getAvater();
                }
                if (avatarH != null && avatarH.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.gDz.gDs = avatarH;
                } else {
                    this.gDz.gDs = "http://tb.himg.baidu.com/sys/portraith/item/" + avatarH;
                }
            }
            this.gDz.gDr = dataRes.timestamp == null ? 0L : dataRes.timestamp.longValue();
            this.gDz.gDt = dataRes.field_info;
            if (!v.isEmpty(dataRes.user_rank)) {
                for (User user : dataRes.user_rank) {
                    if (user != null) {
                        this.gDA.add(a(user));
                    }
                }
            }
            this.gDB = a(dataRes.current_user);
            if (dataRes.rank_description != null) {
                this.foa = dataRes.rank_description.top_link;
                this.gDC = dataRes.rank_description.bottom_link;
            }
            this.gDr = dataRes.timestamp != null ? dataRes.timestamp.longValue() : 0L;
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
            bVar.gDv = user.baijiahao_info.auth_desc;
            Integer num = user.baijiahao_info.auth_id;
            bVar.gDy = (num == null || num.intValue() == 0) ? false : true;
        }
        if (user.influence == null) {
            bVar.gDw = "";
        } else {
            bVar.gDw = String.format(TbadkCoreApplication.getInst().getString(R.string.influence), aq.numFormatOverWanNa(user.influence.intValue()));
        }
        MetaData metaData = new MetaData();
        metaData.parserProtobuf(user);
        if (user.has_concerned == null || user.has_concerned.intValue() == 0) {
            z = false;
        }
        metaData.setIsLike(z);
        bVar.gDx = metaData;
        if (metaData.getAvater() != null && metaData.getAvater().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            bVar.gDu = metaData.getAvater();
        } else {
            bVar.gDu = TbConfig.getPhotoSmallAddress() + metaData.getAvater();
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
