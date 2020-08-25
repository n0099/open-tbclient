package com.baidu.tieba.homepage.personalize.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.q;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.PersonalForum;
/* loaded from: classes16.dex */
public class b extends com.baidu.tieba.card.data.j implements q {
    private CardForum iPN;

    public void a(CardForum cardForum) {
        if (cardForum != null) {
            this.iPN = cardForum;
            this.mGroupTitle = cardForum.card_title;
            if (cardForum.position != null) {
                setYuelaouLocate(ccs() + cardForum.position.intValue());
            } else {
                setYuelaouLocate(ccs() + 0);
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
        if (this.iPN != null) {
            return this.iPN.position.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tieba.card.data.q
    public boolean ccq() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.q
    public void nn(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.q
    public void no(boolean z) {
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
