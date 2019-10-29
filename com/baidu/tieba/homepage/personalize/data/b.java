package com.baidu.tieba.homepage.personalize.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.p;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.PersonalForum;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.data.g implements p {
    private CardForum gmD;

    public void a(CardForum cardForum) {
        if (cardForum != null) {
            this.gmD = cardForum;
            this.mGroupTitle = cardForum.card_title;
            if (cardForum.position != null) {
                setYuelaouLocate(baO() + cardForum.position.intValue());
            } else {
                setYuelaouLocate(baO() + 0);
            }
            if (v.getCount(cardForum.forum_list) > 0) {
                for (PersonalForum personalForum : cardForum.forum_list) {
                    if (personalForum != null && !TextUtils.isEmpty(personalForum.forum_name) && personalForum.forum_id.longValue() > 0) {
                        com.baidu.tieba.card.data.e eVar = new com.baidu.tieba.card.data.e();
                        eVar.forumAvatar = personalForum.avatar;
                        eVar.forumName = personalForum.forum_name;
                        eVar.forumId = com.baidu.adp.lib.g.b.toInt("" + personalForum.forum_id, -1);
                        eVar.isLiked = personalForum.is_like.intValue() == 1;
                        b(eVar);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        if (this.gmD != null) {
            return this.gmD.position.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean baM() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iN(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iO(boolean z) {
        this.showBottomDivider = z;
    }

    public boolean aEG() {
        if (v.getCount(getDataList()) > 0) {
            return true;
        }
        return false;
    }

    public static boolean th(int i) {
        return i == 1;
    }
}
