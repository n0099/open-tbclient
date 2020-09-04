package com.baidu.tieba.homepage.personalize.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.q;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.PersonalForum;
/* loaded from: classes16.dex */
public class b extends com.baidu.tieba.card.data.j implements q {
    private CardForum iPT;

    public void a(CardForum cardForum) {
        if (cardForum != null) {
            this.iPT = cardForum;
            this.mGroupTitle = cardForum.card_title;
            if (cardForum.position != null) {
                setYuelaouLocate(cct() + cardForum.position.intValue());
            } else {
                setYuelaouLocate(cct() + 0);
            }
            if (y.getCount(cardForum.forum_list) > 0) {
                for (PersonalForum personalForum : cardForum.forum_list) {
                    if (personalForum != null && !TextUtils.isEmpty(personalForum.forum_name) && personalForum.forum_id.longValue() > 0) {
                        com.baidu.tieba.card.data.h hVar = new com.baidu.tieba.card.data.h();
                        hVar.forumAvatar = personalForum.avatar;
                        hVar.forumName = personalForum.forum_name;
                        hVar.forumId = com.baidu.adp.lib.f.b.toInt("" + personalForum.forum_id, -1);
                        hVar.isLiked = personalForum.is_like.intValue() == 1;
                        b(hVar);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.card.data.q
    public int getPosition() {
        if (this.iPT != null) {
            return this.iPT.position.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean ccr() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.q
    public void np(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.q
    public void nq(boolean z) {
        this.showBottomDivider = z;
    }

    public boolean isValidate() {
        if (y.getCount(getDataList()) > 0) {
            return true;
        }
        return false;
    }

    public static boolean zY(int i) {
        return i == 1;
    }
}
