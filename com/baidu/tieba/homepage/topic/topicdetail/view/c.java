package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends k {
    private EditText ctU;

    public c(Context context) {
        super(context, (String) null, 29);
        this.csL = false;
        this.csK = 3;
        this.crT = new TopicDetaiInputContainer(context);
        this.ctU = ((TopicDetaiInputContainer) this.crT).getInputView();
        ((TopicDetaiInputContainer) this.crT).setHint(context.getString(R.string.say_your_point));
        this.csM = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText getInputView() {
        return this.ctU;
    }
}
