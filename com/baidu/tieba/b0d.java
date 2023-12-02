package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.tbadk.core.atomData.PaymentConfirmActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes5.dex */
public class b0d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ForumBookInfo forumBookInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, forumBookInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "book_id", forumBookInfo.book_id);
            ktc.a(jSONObject, PaymentConfirmActivityConfig.BOOK_TYPE, forumBookInfo.book_type);
            ktc.a(jSONObject, "book_title", forumBookInfo.book_title);
            ktc.a(jSONObject, "book_cover", forumBookInfo.book_cover);
            ktc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, forumBookInfo.author);
            ktc.a(jSONObject, "forum_pic", forumBookInfo.forum_pic);
            ktc.a(jSONObject, "show_chapter_id", forumBookInfo.show_chapter_id);
            ktc.a(jSONObject, "show_chapter_no", forumBookInfo.show_chapter_no);
            ktc.a(jSONObject, "show_chapter_title", forumBookInfo.show_chapter_title);
            ktc.a(jSONObject, "history_page_id", forumBookInfo.history_page_id);
            ktc.a(jSONObject, "history_paragraph_id", forumBookInfo.history_paragraph_id);
            ktc.a(jSONObject, "history_word_id", forumBookInfo.history_word_id);
            ktc.a(jSONObject, "history_percent", forumBookInfo.history_percent);
            ktc.a(jSONObject, "show_page_id", forumBookInfo.show_page_id);
            ktc.a(jSONObject, "show_paragraph_id", forumBookInfo.show_paragraph_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
