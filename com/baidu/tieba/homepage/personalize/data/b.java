package com.baidu.tieba.homepage.personalize.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.p;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.PersonalForum;
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.data.i implements p {
    private CardForum hgw;

    public void a(CardForum cardForum) {
        if (cardForum != null) {
            this.hgw = cardForum;
            this.mGroupTitle = cardForum.card_title;
            if (cardForum.position != null) {
                setYuelaouLocate(bvE() + cardForum.position.intValue());
            } else {
                setYuelaouLocate(bvE() + 0);
            }
            if (v.getCount(cardForum.forum_list) > 0) {
                for (PersonalForum personalForum : cardForum.forum_list) {
                    if (personalForum != null && !TextUtils.isEmpty(personalForum.forum_name) && personalForum.forum_id.longValue() > 0) {
                        com.baidu.tieba.card.data.g gVar = new com.baidu.tieba.card.data.g();
                        gVar.forumAvatar = personalForum.avatar;
                        gVar.forumName = personalForum.forum_name;
                        gVar.forumId = com.baidu.adp.lib.f.b.toInt("" + personalForum.forum_id, -1);
                        gVar.isLiked = personalForum.is_like.intValue() == 1;
                        b(gVar);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        if (this.hgw != null) {
            return this.hgw.position.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean bvC() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void kx(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void ky(boolean z) {
        this.showBottomDivider = z;
    }

    public boolean isValidate() {
        if (v.getCount(getDataList()) > 0) {
            return true;
        }
        return false;
    }

    public static boolean vA(int i) {
        return i == 1;
    }
}
