package com.baidu.tieba.homepage.personalize.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.p;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.PersonalForum;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.data.g implements p {
    private CardForum gkx;

    public void a(CardForum cardForum) {
        if (cardForum != null) {
            this.gkx = cardForum;
            this.mGroupTitle = cardForum.card_title;
            if (cardForum.position != null) {
                setYuelaouLocate(bag() + cardForum.position.intValue());
            } else {
                setYuelaouLocate(bag() + 0);
            }
            if (v.Z(cardForum.forum_list) > 0) {
                for (PersonalForum personalForum : cardForum.forum_list) {
                    if (personalForum != null && !TextUtils.isEmpty(personalForum.forum_name) && personalForum.forum_id.longValue() > 0) {
                        com.baidu.tieba.card.data.e eVar = new com.baidu.tieba.card.data.e();
                        eVar.forumAvatar = personalForum.avatar;
                        eVar.forumName = personalForum.forum_name;
                        eVar.forumId = com.baidu.adp.lib.g.b.f("" + personalForum.forum_id, -1);
                        eVar.isLiked = personalForum.is_like.intValue() == 1;
                        b(eVar);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        if (this.gkx != null) {
            return this.gkx.position.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bae() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iH(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void iI(boolean z) {
        this.showBottomDivider = z;
    }

    public boolean aDQ() {
        if (v.Z(getDataList()) > 0) {
            return true;
        }
        return false;
    }

    public static boolean ug(int i) {
        return i == 1;
    }
}
